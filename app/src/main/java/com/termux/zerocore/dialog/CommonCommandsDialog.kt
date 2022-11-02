package com.termux.zerocore.dialog

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blockchain.ub.util.custom.dialog.BaseDialogDown
import com.example.xh_lib.utils.UUtils
import com.termux.R
import com.termux.app.TermuxActivity
import com.termux.zerocore.bean.ClipboardBean
import com.termux.zerocore.dialog.adapter.CommonCommandsAdapter
import com.termux.zerocore.utils.ClipBoardUtil
import com.termux.zerocore.utils.FileIOUtils

class CommonCommandsDialog : BaseDialogDown {

    private var recycler_view:RecyclerView? = null
    private var clipboard_note:TextView? = null
    private var clear_text:TextView? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, themeResId: Int) : super(context, themeResId)


    override fun initViewDialog(mView: View) {
        initView(mView)
        initAdapter()
    }
    private fun initView(mView: View) {
        recycler_view = mView.findViewById(R.id.recycler_view)
        clipboard_note = mView.findViewById(R.id.clipboard_note)
        clear_text = mView.findViewById(R.id.clear_text)

    }

    private fun initAdapter() {
        val clipBoardData = FileIOUtils.getClipBoardData()
        clipBoardData?.let {
            if (it.isNotEmpty()) {
                clipboard_note?.visibility = View.GONE
                recycler_view?.visibility = View.VISIBLE
                val arrayList = ArrayList<ClipboardBean.Clipboard>()
                arrayList.addAll(it)
                val mCommonCommandsAdapter = CommonCommandsAdapter(arrayList)
                recycler_view?.adapter = mCommonCommandsAdapter
                val linearLayoutManager = LinearLayoutManager(UUtils.getContext())
                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                recycler_view?.layoutManager = linearLayoutManager
                mCommonCommandsAdapter.setNoDataListener(object : CommonCommandsAdapter.NoDataListener {
                    override fun noData() {
                        clipboard_note?.visibility = View.VISIBLE
                        recycler_view?.visibility = View.INVISIBLE
                    }
                })
                mCommonCommandsAdapter.setClickDataListener(object :CommonCommandsAdapter.ClickDataListener {
                    override fun data(data: String) {
                        TermuxActivity.mTerminalView.sendTextToTerminal(data)
                        dismiss()
                    }
                })
            }
        }

        clear_text?.let {
            it.setOnClickListener {
                FileIOUtils.clearClipBoardString()
                clipboard_note?.visibility = View.VISIBLE
                recycler_view?.visibility = View.INVISIBLE
            }
        }
    }

    override fun getContentView(): Int {
        return R.layout.dialog_common_command
    }
}

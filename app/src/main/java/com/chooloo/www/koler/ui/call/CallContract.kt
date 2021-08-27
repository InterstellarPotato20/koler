package com.chooloo.www.koler.ui.call

import android.net.Uri
import com.chooloo.www.koler.ui.base.BaseContract

interface CallContract : BaseContract {
    interface View : BaseContract.View {
        var stateText: String?
        var stateTextColor: Int
        var callerNameText: String?
        var callerImageURI: Uri?

        fun stopStopwatch()
        fun startStopwatch()
        fun transitionToActiveUI()
        fun animateStateTextAttention()
    }

    interface Presenter<V : View> : BaseContract.Presenter<V> {
        fun onAnswerClick()
        fun onRejectClick()
        fun onCallDetailsChanged(callDetails: CallDetails?)
    }
}
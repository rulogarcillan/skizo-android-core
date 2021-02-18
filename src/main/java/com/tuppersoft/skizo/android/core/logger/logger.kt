package com.tuppersoft.skizo.android.core.logger

import android.util.Log
import com.tuppersoft.skizo.android.core.extension.EMPTY

/**
 * Created by Raúl Rodríguez Concepción on 29/07/2020.
 * raulrcs@gmail.com
 */

object SkizoLog {

    private var enabled = true
    const val TAG = "SkizoLogger"

    fun enabledLogger(flag: Boolean) {
        enabled = flag
    }

    fun v(msg: String = String.EMPTY, tr: Throwable? = null) {
        v(buildTag(), msg, tr)
    }

    fun v(tag: String, msg: String = String.EMPTY, tr: Throwable? = null) {
        if (enabled) {
            tr?.let { Log.v(tag, msg, tr) } ?: Log.v(tag, msg)
        }
    }

    fun d(msg: String = String.EMPTY, tr: Throwable? = null) {
        d(buildTag(), msg, tr)
    }

    fun d(tag: String, msg: String = String.EMPTY, tr: Throwable? = null) {
        if (enabled) {
            tr?.let { Log.d(tag, msg, tr) } ?: Log.d(tag, msg)
        }
    }

    fun i(msg: String = String.EMPTY, tr: Throwable? = null) {
        i(buildTag(), msg, tr)
    }

    fun i(tag: String, msg: String = String.EMPTY, tr: Throwable? = null) {
        if (enabled) {
            tr?.let { Log.i(tag, msg, tr) } ?: Log.i(tag, msg)
        }
    }

    fun w(msg: String = String.EMPTY, tr: Throwable? = null) {
        w(buildTag(), msg, tr)
    }

    fun w(tag: String, msg: String = String.EMPTY, tr: Throwable? = null) {
        if (enabled) {
            tr?.let { Log.w(tag, msg, tr) } ?: Log.w(tag, msg)
        }
    }

    fun e(msg: String = String.EMPTY, tr: Throwable? = null) {
        e(buildTag(), msg, tr)
    }

    fun e(tag: String, msg: String = String.EMPTY, tr: Throwable? = null) {
        if (enabled) {
            tr?.let { Log.e(tag, msg, tr) } ?: Log.e(tag, msg)
        }
    }

    private fun buildTag(): String {
        return try {
            "$TAG " + Thread.currentThread().stackTrace[5].fileName.split("\\.".toRegex())
                .toTypedArray()[0] + "." + Thread.currentThread().stackTrace[5]
                .methodName + ":" + Thread.currentThread().stackTrace[5].lineNumber
        } catch (_: Throwable) {
            TAG
        }
    }
}


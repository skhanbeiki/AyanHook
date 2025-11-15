package ir.ayantech.ayanhook.utils

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import ir.ayantech.ayanadmanager.core.AdCallback
import ir.ayantech.ayanadmanager.core.AyanAdManager
import ir.ayantech.ayanadmanager.utils.constant.AppMarket
import ir.ayantech.ayanhook.R

@SuppressLint("ContextCastToActivity")
@Composable
actual fun AdBannerContainer(
    containerKey: String,
    modifier: Modifier
) {
    val activity = LocalContext.current as AppCompatActivity

    AndroidView(
        modifier = modifier,
        factory = { ctx ->
            val fl = FrameLayout(ctx)
            fl.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View) {
                    println("efgwhjkylly >>> VIEW ATTACHED - calling showAd")
                    AyanAdManager.initialize(
                        appCompatActivity = activity,
                        appMarket = AppMarket.CafeBazaar,
                        appKey = "4ded2a241d550d95812d179653b8fd7be26d8bfc33b196c4572ee5a1cd2e6f28",
                        onSuccess = {
                            val adView = LayoutInflater.from(ctx)
                                .inflate(R.layout.ayan_ads_native_layout_3, null) as ViewGroup
                            AyanAdManager.showAd(
                                useDefaultNativeAdView = false,
                                containerKey = containerKey,
                                appCompatActivity = activity,
                                adSize = null,
                                adContainerId = adView,
                                adCallback = object : AdCallback {
                                    override fun onAdClicked() {
                                        println("efgwhjkylly >>> onAdClicked")
                                    }

                                    override fun onAdFailed(error: String) {
                                        println("efgwhjkylly >>> Ad failed: $error")
                                    }

                                    override fun onAdLoaded() {
                                        fl.removeAllViews()
                                        fl.addView(adView)
                                        println("efgwhjkylly >>> Ad loaded")
                                    }
                                }
                            )
                        },
                        onError = {
                        }
                    )
                    fl.removeOnAttachStateChangeListener(this)
                }

                override fun onViewDetachedFromWindow(v: View) {}
            })

            fl
        }
    )
}

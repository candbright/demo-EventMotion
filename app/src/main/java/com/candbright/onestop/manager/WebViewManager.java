package com.candbright.onestop.manager;

import android.webkit.CookieManager;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeWebViewClient;

/**
 * <p>created by wyh in 2021/12/16</p>
 */
public class WebViewManager {
    private static final String TAG = WebViewManager.class.getSimpleName();
    public BridgeWebView webView;

    public WebViewManager(BridgeWebView webView, BridgeWebViewClient client) {
        this.webView = webView;
        webView.setWebViewClient(client);
        initWebView();

    }

    private void initWebView() {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        // 启用网页存储
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setAppCachePath(LocalFileManager.getCacheDirAbsolutePath());
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
    }
}

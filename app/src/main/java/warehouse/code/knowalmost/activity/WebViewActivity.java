package warehouse.code.knowalmost.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import warehouse.code.knowalmost.R;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.activity
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-22 15:55
 **/
public class WebViewActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);
        webView = (WebView) findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        //设置可以运行JS脚本
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setUseWideViewPort(true); //打开页面时， 自适应屏幕
//		settings.setLoadWithOverviewMode(true);//打开页面时， 自适应屏幕
        settings.setSupportZoom(false);// 用于设置webview放大
        settings.setBuiltInZoomControls(false);
        webView.setWebViewClient(new WebViewClient() {

        });


        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... arg0) {
               /* BufferedReader bufferedReader = null;
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                String data = null;
                try {
                    request.setURI(new URI(arg0[0]));
                    HttpResponse response = client.execute(request);
                    bufferedReader =
                            new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                    StringBuffer sBuffer = new StringBuffer();
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        sBuffer.append(line);
                    }
                    bufferedReader.close();
                    data = sBuffer.toString();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return data;*/
               return null;
            }

            @Override
            protected void onPostExecute(String result) {
                webView.loadDataWithBaseURL(null, result, "text/html", "utf-8", null);

            }
        }.execute("http://baidu.com");
    }
}

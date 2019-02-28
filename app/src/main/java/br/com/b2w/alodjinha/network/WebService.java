package br.com.b2w.alodjinha.network;

import android.os.AsyncTask;

import java.io.IOException;

public class WebService extends AsyncTask<String,Void,String> {
    private AsyncTaskCompleteListener<String> callback;

    private String v1, url;

    public WebService(AsyncTaskCompleteListener<String> cb, String v1, String url){
        this.callback = cb;
        this.v1 = v1;
        this.url = url;
    }

    @Override
    protected String doInBackground(String... strings) {
        String response = "Erro";
        try {
            if (v1.equals("0")){
                response = ApiCall.GET(url);
            }else{
                response = ApiCall.POST(url, WebServiceRequest.reservarProdutoBody());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        callback.onTaskComplete(response);
    }
}
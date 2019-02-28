package br.com.b2w.alodjinha.network;

import okhttp3.FormBody;
import okhttp3.RequestBody;

class WebServiceRequest {

    static RequestBody reservarProdutoBody() {
        return new FormBody.Builder()
                .build();
    }
}

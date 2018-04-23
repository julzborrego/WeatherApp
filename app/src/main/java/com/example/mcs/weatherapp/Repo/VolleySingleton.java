package com.example.mcs.weatherapp.Repo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static VolleySingleton mInstance;
    private static RequestQueue requestQueue;

    private VolleySingleton() {
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInstance==null) {
            mInstance = new VolleySingleton();
        }
        requestQueue = Volley.newRequestQueue(context);
        return mInstance;
    }

    public<T> void addToRequestQueue(Request<T> request) {
        requestQueue.add(request);
    }
}

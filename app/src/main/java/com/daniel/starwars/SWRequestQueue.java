package com.daniel.starwars;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SWRequestQueue {
    protected static SWRequestQueue instance;
    protected Context context;
    protected RequestQueue requestQueue;

    public SWRequestQueue(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized SWRequestQueue getInstance(Context context) {
        if (instance == null) {
            instance = new SWRequestQueue(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

}

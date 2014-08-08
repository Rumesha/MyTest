package com.lk.slmatrimony.services;

import java.io.UnsupportedEncodingException;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MatrimonyRequest<T> extends Request<T> {

	private final Gson mGson;
	private final Class<T> mClazz;
	private final Listener<T> mListener;

	public MatrimonyRequest(int method, String url, Class<T> clazz,
			Listener<T> listener, ErrorListener errorListener) {

		super(Method.GET, url, errorListener);

		this.mClazz = clazz;
		this.mListener = listener; 
		mGson = new Gson();
	}

	public MatrimonyRequest(int method, String url, Class<T> clazz,
			Listener<T> listener, ErrorListener errorListener, Gson gson) {

		super(Method.GET, url, errorListener);
		
		this.mClazz = clazz;
		this.mListener = listener;
		mGson = gson;
	}

	@Override
	protected void deliverResponse(T arg0) {

		mListener.onResponse(arg0);
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {

		try {
			String json = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));

			Log.v("RESPONSE", json);
			return Response.success(mGson.fromJson(json, mClazz),
					HttpHeaderParser.parseIgnoreCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException e) {
			return Response.error(new ParseError(e));
		}
	}

}

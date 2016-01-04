package com.tivra.mh.mhtracker_proto;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.tivra.mh.mhtracker_proto.quoteApi.QuoteApi;
import com.tivra.mh.mhtracker_proto.myApi.MyApi;

import com.tivra.mh.mhtracker_proto.quoteApi.*;
import com.tivra.mh.mhtracker_proto.quoteApi.model.Quote;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ravinder.Singroha on 12/31/2015.
 */




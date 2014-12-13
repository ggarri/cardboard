/*
 * Copyright 2014 Google Inc. All Rights Reserved.

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.vrtoolkit.cardboard.samples.treasurehunt;

import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;
import com.google.vrtoolkit.cardboard.Eye;
import com.google.vrtoolkit.cardboard.HeadTransform;
import com.google.vrtoolkit.cardboard.Viewport;

import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Surface;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import javax.microedition.khronos.egl.EGLConfig;

/**
 * A Cardboard sample application.
 */
public class MainActivity extends CardboardActivity implements CardboardView.StereoRenderer {

    private static final String TAG = "MainActivity";
    private final int TEXTURE_WIDTH = 720;
    private final int TEXTURE_HEIGHT = 720;
    private SurfaceTexture surfaceTexture = null;
    private Surface surface = null;

    /**
     * Contains two sub-views to provide a simple stereo HUD.
     */
    public class CardboardWebView extends WebView {

        public CardboardWebView( Context context ) {
            super(context); // Call WebView's constructor
            setWebChromeClient(new WebChromeClient() {
            });
            setWebViewClient(new WebViewClient());
            setLayoutParams( new ViewGroup.LayoutParams( TEXTURE_WIDTH, TEXTURE_HEIGHT ) );
        }

        @Override
        protected void onDraw( Canvas canvas ) {
            if ( surface != null ) {
                // Requires a try/catch for .lockCanvas( null )
                try {
                    final Canvas surfaceCanvas = surface.lockCanvas( null ); // Android canvas from surface
                    super.onDraw(surfaceCanvas); // Call the WebView onDraw targetting the canvas
                    surface.unlockCanvasAndPost( surfaceCanvas ); // We're done with the canvas!
                } catch ( Surface.OutOfResourcesException excp ) {
                    excp.printStackTrace();
                }
            }
            // super.onDraw( canvas ); // <- Uncomment this if you want to show the original view
        }

    }
//    private Vibrator mVibrator;
//    private CardboardOverlayView mOverlayView;

    /**
     * Sets the view to our CardboardView and initializes the transformation matrices we will use
     * to render our scene.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.common_ui);
        CardboardView cardboardView = (CardboardView) findViewById(R.id.cardboard_view);
        cardboardView.setRenderer(this);
        setCardboardView(cardboardView);
    }

    @Override
    public void onRendererShutdown() {


    }

    @Override
    public void onSurfaceChanged(int width, int height) {
//        int glSurfaceTex = 0;
////        glSurfaceTex = Engine_CreateSurfaceTexture( TEXTURE_WIDTH, TEXTURE_HEIGHT );
//        if ( glSurfaceTex > 0 ) {
//            surfaceTexture = new SurfaceTexture( glSurfaceTex );
//            surfaceTexture.setDefaultBufferSize( TEXTURE_WIDTH, TEXTURE_HEIGHT );
//            surface = new Surface( surfaceTexture );
//        }
    }

    /**
     * Creates the buffers we use to store information about the 3D world.
     *
     * OpenGL doesn't use Java arrays, but rather needs data in a format it can understand.
     * Hence we use ByteBuffers.
     *
     * @param config The EGL configuration used when creating the surface.
     */
    @Override
    public void onSurfaceCreated(EGLConfig config) {

    }


    /**
     * Prepares OpenGL ES before we draw a frame.
     *
     * @param headTransform The head transformation in the new frame.
     */
    @Override
    public void onNewFrame(HeadTransform headTransform) {
//        synchronized ( this ) {
//            surfaceTexture.updateTexImage(); // Update texture
//        }
    }

    /**
     * Draws a frame for an eye.
     *
     * @param eye The eye to render. Includes all required transformations.
     */
    @Override
    public void onDrawEye(Eye eye) {
    }

    @Override
    public void onFinishFrame(Viewport viewport) {
    }


    /**
     * Called when the Cardboard trigger is pulled.
     */
    @Override
    public void onCardboardTrigger() {
    }
}

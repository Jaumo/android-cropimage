/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jaumo.cropimage.gallery;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.InputStream;

/**
 * The interface of all images used in gallery.
 */
public interface IImage {
    int THUMBNAIL_TARGET_SIZE = 320;
    int MINI_THUMB_TARGET_SIZE = 96;
    int THUMBNAIL_MAX_NUM_PIXELS = 512 * 384;
    int MINI_THUMB_MAX_NUM_PIXELS = 128 * 128;
    int UNCONSTRAINED = -1;
    boolean ROTATE_AS_NEEDED = true;
    boolean NO_ROTATE = false;
    boolean USE_NATIVE = true;
    boolean NO_NATIVE = false;

    /**
     * Get the image list which contains this image.
     */
    IImageList getContainer();

    /**
     * Get the bitmap for the full size image.
     */
    Bitmap fullSizeBitmap(int minSideLength,
                          int maxNumberOfPixels);

    Bitmap fullSizeBitmap(int minSideLength,
                          int maxNumberOfPixels, boolean rotateAsNeeded, boolean useNative);

    int getDegreesRotated();

    /**
     * Get the input stream associated with a given full size image.
     */
    InputStream fullSizeImageData();

    Uri fullSizeImageUri();

    /**
     * Get the path of the (full size) image data.
     */
    String getDataPath();

    // Get the title of the image
    String getTitle();

    // Get metadata of the image
    long getDateTaken();

    String getMimeType();

    int getWidth();

    int getHeight();

    // Get property of the image
    boolean isReadonly();

    boolean isDrm();

    // Get the bitmap of the medium thumbnail
    Bitmap thumbBitmap(boolean rotateAsNeeded);

    // Get the bitmap of the mini thumbnail.
    Bitmap miniThumbBitmap();

    // Rotate the image
    boolean rotateImageBy(int degrees);

}

package com.junjc9.funu.interfaces.camera

abstract class FunUCamera {
    abstract fun getFrontCameraId(): Int

    abstract fun getBackCameraId(): Int

    abstract fun getCountOfCameras(): Int
}

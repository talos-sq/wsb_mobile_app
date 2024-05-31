package m.l.wsb_mobile_app

import android.app.Application
import android.util.Log

class TasksApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("MyTaskApp", "Application onCreate()")
    }
}
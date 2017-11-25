package org.mariotaku.twidere.service

import android.app.IntentService
import android.content.SharedPreferences
import com.twitter.Extractor
import org.mariotaku.twidere.dagger.component.GeneralComponent
import org.mariotaku.twidere.extension.get
import org.mariotaku.twidere.util.NotificationManagerWrapper
import org.mariotaku.twidere.util.UserColorNameManager
import javax.inject.Inject

abstract class BaseIntentService(tag: String) : IntentService(tag) {

    @Inject
    lateinit var preferences: SharedPreferences
    @Inject
    lateinit var notificationManager: NotificationManagerWrapper
    @Inject
    lateinit var extractor: Extractor
    @Inject
    lateinit var userColorNameManager: UserColorNameManager

    override fun onCreate() {
        super.onCreate()
        GeneralComponent.get(this).inject(this)
    }
}
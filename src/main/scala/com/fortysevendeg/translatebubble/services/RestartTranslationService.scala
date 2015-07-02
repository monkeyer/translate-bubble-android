/*
 * Copyright (C) 2015 47 Degrees, LLC http://47deg.com hello@47deg.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortysevendeg.translatebubble.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.fortysevendeg.translatebubble.modules.ComponentRegistryImpl
import macroid.Contexts

class RestartTranslationService
  extends Service
  with Contexts[Service]
  with ComponentRegistryImpl {

  override lazy val contextProvider = serviceContextWrapper

  override def onStartCommand(intent: Intent, flags: Int, startId: Int): Int =
    super.onStartCommand(intent, flags, startId)

  override def onCreate(): Unit = {
    super.onCreate()
    persistentServices.enableTranslation()
  }

  override def onBind(intent: Intent): IBinder = null

}

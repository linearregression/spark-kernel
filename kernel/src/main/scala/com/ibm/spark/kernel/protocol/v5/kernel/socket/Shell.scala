/*
 * Copyright 2014 IBM Corp.
 *
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

package com.ibm.spark.kernel.protocol.v5.kernel.socket

import com.ibm.spark.kernel.protocol.v5.kernel.ActorLoader
import com.ibm.spark.kernel.protocol.v5.SystemActorType

/**
 * The server endpoint for shell messages specified in the IPython Kernel Spec
 * @param socketFactory A factory to create the ZeroMQ socket connection
 * @param actorLoader The actor loader to use to load the relay for kernel
 *                    messages
 */
class Shell(socketFactory: SocketFactory, actorLoader: ActorLoader)
  extends ZeromqKernelMessageSocket(
    socketFactory.Shell,
    () => actorLoader.load(SystemActorType.KernelMessageRelay)
  )
{
  logger.trace("Created new Shell actor")
}

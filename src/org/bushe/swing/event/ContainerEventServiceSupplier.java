/**
 * Copyright 2005 Bushe Enterprises, Inc., Hopkinton, MA, USA, www.bushe.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bushe.swing.event;

/**
 * A interface implemented by a Swing Container to supplier of an EventService to it's children.
 * <p/>
 * A Container EventService is, unlike the {@link EventBus}, an {@link EventService} that is container specific, in
 * other words it is shared only among components within a container.  The only difference between a Container
 * EventService any other EventService is that it's found and used by a children of a container.  The api and available
 * implementations all work the same as any other EventService.
 * <p/>
 * A good example of a ContainerEventServiceSupplier is a Form class.  The components that the Form containes can
 * publish EventServiceEvents when they they change state - for example when their values change or when they become
 * invalid or valid.  The Form may have a model that collects the user's entries by subscribing to EventServiceEvents
 * published on the Form's EventService. A FormValidator may also listen to EventServiceEvents published on the Form's
 * EventService to handle validation errors.  The Form's components don't have to know about the form, or the model or
 * the validator.  They just publish event's on their Container's EventService, which they can find by using a {@link
 * ContainerEventServiceFinder}.
 * <p/>
 * This class does not ever have to be implemented.  The ContainerEventServiceFinder will create a ContainerEventService
 * on JRootPanes by default.  So each dialog and Frame will have their own automatically.  You only want to implement
 * this interface when you want to limit events to subscribers in containers smaller than a JRootPane.
 *
 * @author Michael Bushe michael@bushe.com
 */
public interface ContainerEventServiceSupplier {
   public EventService getContainerEventService();
}
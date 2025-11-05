@file:Suppress("DeprecatedCallableAddReplaceWith", "DEPRECATION")

package org.unbrokendome.gradle.pluginutils

import org.gradle.api.plugins.ExtensionAware


/**
 * Gets the extension of the given name if it exists.
 *
 * Will return `null` if the receiver is not [ExtensionAware].
 *
 * @receiver the object containing extensions
 * @param name the extension name
 * @return the extension, or `null` if it does not exist
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> Any.extension(name: String): T? =
    (this as? ExtensionAware)?.extensions?.findByName(name) as T?


/**
 * Gets the extension of the given name, throwing an exception if it does not exist.
 *
 * @receiver the object containing extensions
 * @param name the extension name
 * @return the extension
 * @throws ClassCastException if the receiver object is not [ExtensionAware]
 * @throws org.gradle.api.UnknownDomainObjectException if the extension does not exist
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> Any.requiredExtension(name: String): T =
    (this as ExtensionAware).extensions.getByName(name) as T


/**
 * Gets the extension of the given type if it exists.
 *
 * Will return `null` if the receiver is not [ExtensionAware].
 *
 * @receiver the object containing extensions
 * @param <T> the extension type
 * @return the extension, or `null` if it does not exist
 */
inline fun <reified T : Any> Any.extension(): T? =
    (this as? ExtensionAware)?.extensions?.findByType(typeOf<T>())


/**
 * Gets the extension of the given type, throwing an exception if it does not exist.
 *
 * @receiver the object containing extensions
 * @param <T> the extension type
 * @return the extension
 * @throws ClassCastException if the receiver object is not [ExtensionAware]
 * @throws org.gradle.api.UnknownDomainObjectException if the extension does not exist
 */
inline fun <reified T : Any> Any.requiredExtension(): T =
    (this as ExtensionAware).extensions.getByType(typeOf<T>())

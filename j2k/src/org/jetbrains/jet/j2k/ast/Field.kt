/*
 * Copyright 2010-2013 JetBrains s.r.o.
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

package org.jetbrains.jet.j2k.ast

import org.jetbrains.jet.j2k.ast.types.Type
import org.jetbrains.jet.j2k.*
import java.util.ArrayList

open class Field(
        val identifier: Identifier,
        comments: MemberComments,
        modifiers: Set<Modifier>,
        val `type`: Type,
        val initializer: Element,
        val writingAccesses: Int
) : Member(comments, modifiers) {

    fun modifiersToKotlin(): String {
        val modifierList = ArrayList<Modifier>()
        if (isAbstract()) {
            modifierList.add(Modifier.ABSTRACT)
        }

        val modifier = accessModifier()
        if (modifier != null) {
            modifierList.add(modifier)
        }

        return modifierList.toKotlin() + (if (isVal()) "val " else "var ")
    }

    fun isVal(): Boolean = modifiers.contains(Modifier.FINAL)

    override fun toKotlin(): String {
        val declaration: String = commentsToKotlin() +
        modifiersToKotlin() + identifier.toKotlin() + " : " + `type`.toKotlin()
        if (initializer.isEmpty()) {
            return declaration + ((if (isVal() && !isStatic() && writingAccesses != 0)
                ""
            else
                " = " + getDefaultInitializer(this)))
        }

        return declaration + " = " + initializer.toKotlin()
    }
}

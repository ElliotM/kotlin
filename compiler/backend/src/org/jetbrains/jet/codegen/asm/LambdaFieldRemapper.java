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

package org.jetbrains.jet.codegen.asm;

import org.jetbrains.asm4.Opcodes;
import org.jetbrains.asm4.tree.AbstractInsnNode;
import org.jetbrains.asm4.tree.FieldInsnNode;
import org.jetbrains.asm4.tree.MethodNode;
import org.jetbrains.asm4.tree.VarInsnNode;

import static org.jetbrains.jet.codegen.asm.MethodInliner.getPreviousNoLableNoLine;

public class LambdaFieldRemapper {

    public AbstractInsnNode doTransform(MethodNode node, FieldInsnNode fieldInsnNode, CapturedParamInfo capturedField) {
        AbstractInsnNode prev = getPreviousNoLableNoLine(fieldInsnNode);

        assert prev.getType() == AbstractInsnNode.VAR_INSN;
        VarInsnNode loadThis = (VarInsnNode) prev;
        assert /*loadThis.var == info.getCapturedVarsSize() - 1 && */loadThis.getOpcode() == Opcodes.ALOAD;

        int opcode = fieldInsnNode.getOpcode() == Opcodes.GETFIELD ? capturedField.getType().getOpcode(Opcodes.ILOAD) : capturedField.getType().getOpcode(Opcodes.ISTORE);
        VarInsnNode insn = new VarInsnNode(opcode, capturedField.getIndex());

        node.instructions.remove(prev); //remove aload this
        node.instructions.insertBefore(fieldInsnNode, insn);
        node.instructions.remove(fieldInsnNode); //remove aload field

        return insn;
    }

}

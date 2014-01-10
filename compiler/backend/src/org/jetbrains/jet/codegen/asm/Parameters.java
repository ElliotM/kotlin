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

import com.google.common.collect.Iterables;
import org.jetbrains.asm4.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parameters implements Iterable<ParameterInfo> {

    private final List<ParameterInfo> real;

    private final List<CapturedParamInfo> captured;

    public Parameters(List<ParameterInfo> real, List<CapturedParamInfo> captured) {
        this.real = real;
        this.captured = captured;
    }

    public List<ParameterInfo> getReal() {
        return real;
    }

    public List<CapturedParamInfo> getCaptured() {
        return captured;
    }

    public int totalSize() {
        return real.size() + captured.size();
    }

    public ParameterInfo get(int index) {
        if (index < real.size()) {
            return real.get(index);
        }
        return captured.get(index - real.size());
    }

    public Iterator<ParameterInfo> iterator() {
        return Iterables.<ParameterInfo>concat(real, captured).iterator();
    }

    public static List<CapturedParamInfo> transformList(List<CapturedParamInfo> capturedParams, int realSize) {
        ArrayList result = new ArrayList();
        for (CapturedParamInfo capturedParamInfo : capturedParams) {
            CapturedParamInfo newInfo =
                    new CapturedParamInfo(capturedParamInfo.getFieldName(), capturedParamInfo.getType(), capturedParamInfo.isSkipped,
                                          capturedParamInfo.getIndex(), result.size() + realSize);

            newInfo.setLambda(capturedParamInfo.getLambda());

            result.add(newInfo);

            if (capturedParamInfo.getType().getSize() == 2) {
                result.add(CapturedParamInfo.STUB);
            }
        }
        return result;
    }

    public static List<CapturedParamInfo> addStubs(List<CapturedParamInfo> capturedParams, int realSize) {
        ArrayList result = new ArrayList();
        for (CapturedParamInfo capturedParamInfo : capturedParams) {
            CapturedParamInfo newInfo = new CapturedParamInfo(capturedParamInfo.getFieldName(), capturedParamInfo.getType(), capturedParamInfo.isSkipped,
                                                              capturedParamInfo.getRemapIndex(), result.size() + realSize);
            newInfo.setLambda(capturedParamInfo.getLambda());
            result.add(newInfo);
            if (capturedParamInfo.getType().getSize() == 2) {
                result.add(CapturedParamInfo.STUB);
            }
        }
        return result;
    }

    public static List<ParameterInfo> addStubs(List<ParameterInfo> params) {
        ArrayList result = new ArrayList();
        for (ParameterInfo newInfo : params) {
            result.add(newInfo);
            if (newInfo.getType().getSize() == 2) {
                result.add(ParameterInfo.STUB);
            }
        }
        return result;
    }

    public ArrayList<Type> getCapturedTypes() {
        ArrayList result = new ArrayList();
        for (CapturedParamInfo info : captured) {
            if(info != CapturedParamInfo.STUB) {
                Type type = info.getType();
                result.add(type);
            }
        }
        return result;
    }
}
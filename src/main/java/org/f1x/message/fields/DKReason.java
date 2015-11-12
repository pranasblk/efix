/*
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

package org.f1x.message.fields;

// Generated by org.f1x.tools.DictionaryGenerator from QuickFIX dictionary
public enum DKReason implements org.f1x.message.types.ByteEnum {
    UNKNOWN_SYMBOL((byte) 'A'),
    WRONG_SIDE((byte) 'B'),
    QUANTITY_EXCEEDS_ORDER((byte) 'C'),
    NO_MATCHING_ORDER((byte) 'D'),
    PRICE_EXCEEDS_LIMIT((byte) 'E'),
    CALCULATION_DIFFERENCE((byte) 'F'),
    OTHER((byte) 'Z');

    private final byte code;

    DKReason(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static DKReason parse(String s) {
        switch (s) {
            case "A":
                return UNKNOWN_SYMBOL;
            case "B":
                return WRONG_SIDE;
            case "C":
                return QUANTITY_EXCEEDS_ORDER;
            case "D":
                return NO_MATCHING_ORDER;
            case "E":
                return PRICE_EXCEEDS_LIMIT;
            case "F":
                return CALCULATION_DIFFERENCE;
            case "Z":
                return OTHER;
        }
        return null;
    }

}
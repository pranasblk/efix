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
public enum DiscretionInst implements org.f1x.message.types.ByteEnum {
    RELATED_TO_DISPLAYED_PRICE((byte) '0'),
    RELATED_TO_MARKET_PRICE((byte) '1'),
    RELATED_TO_PRIMARY_PRICE((byte) '2'),
    RELATED_TO_LOCAL_PRIMARY_PRICE((byte) '3'),
    RELATED_TO_MIDPOINT_PRICE((byte) '4'),
    RELATED_TO_LAST_TRADE_PRICE((byte) '5'),
    RELATED_TO_VWAP((byte) '6');

    private final byte code;

    DiscretionInst(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static DiscretionInst parse(String s) {
        switch (s) {
            case "0":
                return RELATED_TO_DISPLAYED_PRICE;
            case "1":
                return RELATED_TO_MARKET_PRICE;
            case "2":
                return RELATED_TO_PRIMARY_PRICE;
            case "3":
                return RELATED_TO_LOCAL_PRIMARY_PRICE;
            case "4":
                return RELATED_TO_MIDPOINT_PRICE;
            case "5":
                return RELATED_TO_LAST_TRADE_PRICE;
            case "6":
                return RELATED_TO_VWAP;
        }
        return null;
    }

}
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
public enum AllocReportType implements org.f1x.message.types.ByteEnum {
    SELLSIDE_CALCULATED_USING_PRELIMINARY((byte) '3'),
    SELLSIDE_CALCULATED_WITHOUT_PRELIMINARY((byte) '4'),
    WAREHOUSE_RECAP((byte) '5'),
    REQUEST_TO_INTERMEDIARY((byte) '8');

    private final byte code;

    AllocReportType(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static AllocReportType parse(String s) {
        switch (s) {
            case "3":
                return SELLSIDE_CALCULATED_USING_PRELIMINARY;
            case "4":
                return SELLSIDE_CALCULATED_WITHOUT_PRELIMINARY;
            case "5":
                return WAREHOUSE_RECAP;
            case "8":
                return REQUEST_TO_INTERMEDIARY;
        }
        return null;
    }

}
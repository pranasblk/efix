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
public enum ClearingInstruction implements org.f1x.message.types.IntEnum {
    PROCESS_NORMALLY(0),
    EXCLUDE_FROM_ALL_NETTING(1),
    BILATERAL_NETTING_ONLY(2),
    EX_CLEARING(3),
    SPECIAL_TRADE(4),
    MULTILATERAL_NETTING(5),
    CLEAR_AGAINST_CENTRAL_COUNTERPARTY(6),
    EXCLUDE_FROM_CENTRAL_COUNTERPARTY(7),
    MANUAL_MODE(8),
    AUTOMATIC_POSTING_MODE(9),
    AUTOMATIC_GIVE_UP_MODE(10),
    QUALIFIED_SERVICE_REPRESENTATIVE(11),
    CUSTOMER_TRADE(12),
    SELF_CLEARING(13);

    private final int code;

    ClearingInstruction(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ClearingInstruction parse(String s) {
        switch (s) {
            case "0":
                return PROCESS_NORMALLY;
            case "1":
                return EXCLUDE_FROM_ALL_NETTING;
            case "2":
                return BILATERAL_NETTING_ONLY;
            case "3":
                return EX_CLEARING;
            case "4":
                return SPECIAL_TRADE;
            case "5":
                return MULTILATERAL_NETTING;
            case "6":
                return CLEAR_AGAINST_CENTRAL_COUNTERPARTY;
            case "7":
                return EXCLUDE_FROM_CENTRAL_COUNTERPARTY;
            case "8":
                return MANUAL_MODE;
            case "9":
                return AUTOMATIC_POSTING_MODE;
            case "10":
                return AUTOMATIC_GIVE_UP_MODE;
            case "11":
                return QUALIFIED_SERVICE_REPRESENTATIVE;
            case "12":
                return CUSTOMER_TRADE;
            case "13":
                return SELF_CLEARING;
        }
        return null;
    }

}
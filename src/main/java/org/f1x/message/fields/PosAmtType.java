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
public enum PosAmtType implements org.f1x.message.types.StringEnum {
    FINAL_MARK_TO_MARKET_AMOUNT("FMTM"),
    INCREMENTAL_MARK_TO_MARKET_AMOUNT("IMTM"),
    TRADE_VARIATION_AMOUNT("TVAR"),
    START_OF_DAY_MARK_TO_MARKET_AMOUNT("SMTM"),
    PREMIUM_AMOUNT("PREM"),
    CASH_RESIDUAL_AMOUNT("CRES"),
    CASH_AMOUNT("CASH"),
    VALUE_ADJUSTED_AMOUNT("VADJ");

    private final String code;

    PosAmtType(String code) {
        this.code = code;
        bytes = code.getBytes();
    }

    public String getCode() {
        return code;
    }

    private final byte[] bytes;

    public byte[] getBytes() {
        return bytes;
    }


    public static PosAmtType parse(String s) {
        switch (s) {
            case "FMTM":
                return FINAL_MARK_TO_MARKET_AMOUNT;
            case "IMTM":
                return INCREMENTAL_MARK_TO_MARKET_AMOUNT;
            case "TVAR":
                return TRADE_VARIATION_AMOUNT;
            case "SMTM":
                return START_OF_DAY_MARK_TO_MARKET_AMOUNT;
            case "PREM":
                return PREMIUM_AMOUNT;
            case "CRES":
                return CASH_RESIDUAL_AMOUNT;
            case "CASH":
                return CASH_AMOUNT;
            case "VADJ":
                return VALUE_ADJUSTED_AMOUNT;
        }
        return null;
    }

}
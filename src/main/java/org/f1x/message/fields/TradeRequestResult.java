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
public enum TradeRequestResult implements org.f1x.message.types.IntEnum {
    SUCCESSFUL(0),
    INVALID_OR_UNKNOWN_INSTRUMENT(1),
    INVALID_TYPE_OF_TRADE_REQUESTED(2),
    INVALID_PARTIES(3),
    INVALID_TRANSPORT_TYPE_REQUESTED(4),
    INVALID_DESTINATION_REQUESTED(5),
    TRADEREQUESTTYPE_NOT_SUPPORTED(8),
    UNAUTHORIZED_FOR_TRADE_CAPTURE_REPORT_REQUEST(9),
    OTHER(99);

    private final int code;

    TradeRequestResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TradeRequestResult parse(String s) {
        switch (s) {
            case "0":
                return SUCCESSFUL;
            case "1":
                return INVALID_OR_UNKNOWN_INSTRUMENT;
            case "2":
                return INVALID_TYPE_OF_TRADE_REQUESTED;
            case "3":
                return INVALID_PARTIES;
            case "4":
                return INVALID_TRANSPORT_TYPE_REQUESTED;
            case "5":
                return INVALID_DESTINATION_REQUESTED;
            case "8":
                return TRADEREQUESTTYPE_NOT_SUPPORTED;
            case "9":
                return UNAUTHORIZED_FOR_TRADE_CAPTURE_REPORT_REQUEST;
            case "99":
                return OTHER;
        }
        return null;
    }

}
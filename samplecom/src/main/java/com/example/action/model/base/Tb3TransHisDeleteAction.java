package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb3TransHis;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 変遷履歴削除
 *
 * @author emarfkrow
 */
public class Tb3TransHisDeleteAction extends BaseAction {

    /** 変遷履歴削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object transId = postJson.get("transId");
        if (transId == null) {
            transId = postJson.get("Tb3TransHis.transId");
        }
        if (transId == null) {
            throw new OptLockError("error.cant.delete", "変遷履歴");
        }
        Object transBn = postJson.get("transBn");
        if (transBn == null) {
            transBn = postJson.get("Tb3TransHis.transBn");
        }
        if (transBn == null) {
            throw new OptLockError("error.cant.delete", "変遷履歴");
        }

        Tb3TransHis e = FormValidator.toBean(Tb3TransHis.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "変遷履歴");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

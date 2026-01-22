package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb3Trans;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 変遷削除
 *
 * @author emarfkrow
 */
public class Tb3TransDeleteAction extends BaseAction {

    /** 変遷削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object transId = postJson.get("transId");
        if (transId == null) {
            transId = postJson.get("Tb3Trans.transId");
        }
        if (transId == null) {
            throw new OptLockError("error.cant.delete", "変遷");
        }

        Tb3Trans e = FormValidator.toBean(Tb3Trans.class.getName(), postJson);

        java.util.List<com.example.entity.Tb3TransHis> tb3TransHiss = e.referTb3TransHiss();
        if (tb3TransHiss != null) {
            for (com.example.entity.Tb3TransHis tb3TransHis : tb3TransHiss) {

                if (tb3TransHis.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "変遷履歴");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "変遷");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

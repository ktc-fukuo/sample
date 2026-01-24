package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Dinks;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 子なし削除
 *
 * @author emarfkrow
 */
public class T01DinksDeleteAction extends BaseAction {

    /** 子なし削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object oyaId = postJson.get("oyaId");
        if (oyaId == null) {
            oyaId = postJson.get("T01Dinks.oyaId");
        }
        if (oyaId == null) {
            throw new OptLockError("error.cant.delete", "子なし");
        }
        Object koBn = postJson.get("koBn");
        if (koBn == null) {
            koBn = postJson.get("T01Dinks.koBn");
        }
        if (koBn == null) {
            throw new OptLockError("error.cant.delete", "子なし");
        }

        T01Dinks e = FormValidator.toBean(T01Dinks.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "子なし");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

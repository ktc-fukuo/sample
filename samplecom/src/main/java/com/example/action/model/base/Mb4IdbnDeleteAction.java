package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Mb4Idbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * ID連番マスタ削除
 *
 * @author emarfkrow
 */
public class Mb4IdbnDeleteAction extends BaseAction {

    /** ID連番マスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object idbnId = postJson.get("idbnId");
        if (idbnId == null) {
            idbnId = postJson.get("Mb4Idbn.idbnId");
        }
        if (idbnId == null) {
            throw new OptLockError("error.cant.delete", "ID連番マスタ");
        }
        Object idbnBn = postJson.get("idbnBn");
        if (idbnBn == null) {
            idbnBn = postJson.get("Mb4Idbn.idbnBn");
        }
        if (idbnBn == null) {
            throw new OptLockError("error.cant.delete", "ID連番マスタ");
        }

        Mb4Idbn e = FormValidator.toBean(Mb4Idbn.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "ID連番マスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

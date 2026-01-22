package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Kisei;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 寄生削除
 *
 * @author emarfkrow
 */
public class Tb6KiseiDeleteAction extends BaseAction {

    /** 寄生削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object kiseiId = postJson.get("kiseiId");
        if (kiseiId == null) {
            kiseiId = postJson.get("Tb6Kisei.kiseiId");
        }
        if (kiseiId == null) {
            throw new OptLockError("error.cant.delete", "寄生");
        }

        Tb6Kisei e = FormValidator.toBean(Tb6Kisei.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "寄生");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Kisei2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 寄生削除
 *
 * @author emarfkrow
 */
public class Tb6Kisei2DeleteAction extends BaseAction {

    /** 寄生削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object kisei2Id = postJson.get("kisei2Id");
        if (kisei2Id == null) {
            kisei2Id = postJson.get("Tb6Kisei2.kisei2Id");
        }
        if (kisei2Id == null) {
            throw new OptLockError("error.cant.delete", "寄生");
        }

        Tb6Kisei2 e = FormValidator.toBean(Tb6Kisei2.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "寄生");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

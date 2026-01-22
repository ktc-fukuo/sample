package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Mb4No;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * NOマスタ削除
 *
 * @author emarfkrow
 */
public class Mb4NoDeleteAction extends BaseAction {

    /** NOマスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object refNo = postJson.get("refNo");
        if (refNo == null) {
            refNo = postJson.get("Mb4No.refNo");
        }
        if (refNo == null) {
            throw new OptLockError("error.cant.delete", "NOマスタ");
        }

        Mb4No e = FormValidator.toBean(Mb4No.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "NOマスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

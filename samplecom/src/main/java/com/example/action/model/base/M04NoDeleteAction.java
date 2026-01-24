package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04No;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * NOマスタ削除
 *
 * @author emarfkrow
 */
public class M04NoDeleteAction extends BaseAction {

    /** NOマスタ削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object norefNo = postJson.get("norefNo");
        if (norefNo == null) {
            norefNo = postJson.get("M04No.norefNo");
        }
        if (norefNo == null) {
            throw new OptLockError("error.cant.delete", "NOマスタ");
        }

        M04No e = FormValidator.toBean(M04No.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "NOマスタ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

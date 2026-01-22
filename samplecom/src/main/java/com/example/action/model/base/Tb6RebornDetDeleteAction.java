package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6RebornDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 転生明細削除
 *
 * @author emarfkrow
 */
public class Tb6RebornDetDeleteAction extends BaseAction {

    /** 転生明細削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("Tb6RebornDet.rebornId");
        }
        if (rebornId == null) {
            throw new OptLockError("error.cant.delete", "転生明細");
        }
        Object rebornBn = postJson.get("rebornBn");
        if (rebornBn == null) {
            rebornBn = postJson.get("Tb6RebornDet.rebornBn");
        }
        if (rebornBn == null) {
            throw new OptLockError("error.cant.delete", "転生明細");
        }

        Tb6RebornDet e = FormValidator.toBean(Tb6RebornDet.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "転生明細");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

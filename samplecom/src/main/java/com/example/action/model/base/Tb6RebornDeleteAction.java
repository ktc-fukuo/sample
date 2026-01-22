package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Reborn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 転生削除
 *
 * @author emarfkrow
 */
public class Tb6RebornDeleteAction extends BaseAction {

    /** 転生削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("Tb6Reborn.rebornId");
        }
        if (rebornId == null) {
            throw new OptLockError("error.cant.delete", "転生");
        }

        Tb6Reborn e = FormValidator.toBean(Tb6Reborn.class.getName(), postJson);

        java.util.List<com.example.entity.Tb6RebornDet> tb6RebornDets = e.referTb6RebornDets();
        if (tb6RebornDets != null) {
            for (com.example.entity.Tb6RebornDet tb6RebornDet : tb6RebornDets) {

                if (tb6RebornDet.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "転生明細");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "転生");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

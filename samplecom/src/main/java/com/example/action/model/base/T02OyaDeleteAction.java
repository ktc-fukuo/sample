package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 親削除
 *
 * @author emarfkrow
 */
public class T02OyaDeleteAction extends BaseAction {

    /** 親削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object oyaId = form.get("oyaId");
        if (oyaId == null) {
            oyaId = form.get("T02Oya.oyaId");
        }
        if (oyaId == null) {
            throw new OptLockError("error.cant.delete", "親");
        }

        T02Oya e = FormValidator.toBean(T02Oya.class.getName(), form);

        // 子：子なしを全て指定済みか確認
        int orgT02DinkssSize = e.getT02Dinkss().size();
        if (e.referT02Dinkss().size() != orgT02DinkssSize) {
            throw new OptLockError("error.cant.delete", "子なし");
        }

        // 子：子を全て指定済みか確認
        int orgT02KosSize = e.getT02Kos().size();
        if (e.referT02Kos().size() != orgT02KosSize) {
            throw new OptLockError("error.cant.delete", "子");
        }
        for (com.example.entity.T02Ko t02Ko : e.getT02Kos()) {
            t02Ko.nestT02Magos();
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "親");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}

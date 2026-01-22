/**
 * 孤児グリッド定義
 */

let Tb1OrphanGridColumns = [];

$(function() {
    Tb1OrphanGridColumns = [
        Column.text('OYA_ID', Messages['Tb1OrphanGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['Tb1OrphanGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('ORPHAN_INFO', Messages['Tb1OrphanGrid.orphanInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb1OrphanGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});

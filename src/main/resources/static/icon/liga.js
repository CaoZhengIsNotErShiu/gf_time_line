/* A polyfill for browsers that don't support ligatures. */
/* The script tag referring to this file must be placed before the ending body tag. */

/* To provide support for elements dynamically added, this script adds
   method 'icomoonLiga' to the window object. You can pass element references to this method.
*/
(function () {
    'use strict';
    function supportsProperty(p) {
        var prefixes = ['Webkit', 'Moz', 'O', 'ms'],
            i,
            div = document.createElement('div'),
            ret = p in div.style;
        if (!ret) {
            p = p.charAt(0).toUpperCase() + p.substr(1);
            for (i = 0; i < prefixes.length; i += 1) {
                ret = prefixes[i] + p in div.style;
                if (ret) {
                    break;
                }
            }
        }
        return ret;
    }
    var icons;
    if (!supportsProperty('fontFeatureSettings')) {
        icons = {
            'home': '&#x1f32b;',
            'house': '&#x1f32b;',
            'pencil': '&#xe905;',
            'write': '&#xe905;',
            'pencil2': '&#xe906;',
            'write2': '&#xe906;',
            'images': '&#xe90e;',
            'pictures': '&#xe90e;',
            'camera': '&#xe90f;',
            'photo': '&#xe90f;',
            'music': '&#xe911;',
            'song': '&#xe911;',
            'film': '&#xe913;',
            'video2': '&#xe913;',
            'video-camera': '&#xe914;',
            'video3': '&#xe914;',
            'pacman': '&#xe916;',
            'game2': '&#xe916;',
            'bullhorn': '&#xe91a;',
            'megaphone': '&#xe91a;',
            'copy': '&#xe92c;',
            'duplicate': '&#xe92c;',
            'folder-open': '&#xe930;',
            'directory2': '&#xe930;',
            'price-tag': '&#xe935;',
            'price-tags': '&#xe936;',
            'qrcode': '&#xe938;',
            'phone-hang-up': '&#xe943;',
            'telephone2': '&#xe943;',
            'redo2': '&#xe968;',
            'right': '&#xe968;',
            'bubble2': '&#xe96e;',
            'comment2': '&#xe96e;',
            'user': '&#xe971;',
            'profile2': '&#xe971;',
            'user-plus': '&#xe973;',
            'user2': '&#xe973;',
            'fire': '&#xe9a9;',
            'flame': '&#xe9a9;',
            'heart': '&#xe9da;',
            'like': '&#xe9da;',
            'heart-broken': '&#xe9db;',
            'heart2': '&#xe9db;',
          '0': 0
        };
        delete icons['0'];
        window.icomoonLiga = function (els) {
            var classes,
                el,
                i,
                innerHTML,
                key;
            els = els || document.getElementsByTagName('*');
            if (!els.length) {
                els = [els];
            }
            for (i = 0; ; i += 1) {
                el = els[i];
                if (!el) {
                    break;
                }
                classes = el.className;
                if (/icon-/.test(classes)) {
                    innerHTML = el.innerHTML;
                    if (innerHTML && innerHTML.length > 1) {
                        for (key in icons) {
                            if (icons.hasOwnProperty(key)) {
                                innerHTML = innerHTML.replace(new RegExp(key, 'g'), icons[key]);
                            }
                        }
                        el.innerHTML = innerHTML;
                    }
                }
            }
        };
        window.icomoonLiga();
    }
}());

(function () {
    function _init() {

        // Gallery
        new MODALit({
            el: '.demo-gallery',
            slider: true,
            width: 'large',
            navi: true,
            footer: false,
            transition: 'zoom'
        });




        // Scroll
        var scrl = new MODALit({
                target: '#scroller',
                backdrop: false,
                position: 'right bottom',
                cancel: {
                    fn: function () {
                        this.view = true;
                    }
                },
                transition: 'slideUp'
            }),
            pos = 0,
            timer = null,
            ofs = function () {
                var rect = document.getElementById('scroll').getBoundingClientRect();
                pos = rect.top + rect.height + window.pageYOffset - window.innerHeight + 100;
            },
            _onScroll = function () {
                if (!scrl.view) {
                    var scrlTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop,
                        hidden = scrl.modal.getAttribute('aria-hidden');
                    clearTimeout(timer);
                    timer = setTimeout(function () {
                        if (scrlTop > pos) {
                            hidden === 'true' && scrl.show(scrl.modal);
                        } else {
                            hidden === 'false' && scrl.hide();
                        }
                    }, 50)
                }
            };
        ofs();
        window.addEventListener('resize', ofs);
        window.addEventListener('scroll', _onScroll);
    }

    onload = _init;

}).call(this);

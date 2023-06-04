/**
 * Perfect Scrollbar
 */
'use strict';

import {PerfectScrollbar} from "../../libs/perfect-scrollbar/perfect-scrollbar";

document.addEventListener('DOMContentLoaded', function () {
  (function () {
    const verticalExample = document.getElementById('vertical-example'),
        verticalExample2 = document.getElementById('vertical-example2'),
        verticalExample3 = document.getElementById('vertical-example3');

    // Vertical Example
    // --------------------------------------------------------------------
    if (verticalExample) {
      new PerfectScrollbar(verticalExample, {
        wheelPropagation: false
      });
    }

    if (verticalExample2) {
      new PerfectScrollbar(verticalExample2,{
        wheelPropagation: false
      });
    }

    if (verticalExample3) {
      new PerfectScrollbar(verticalExample3, {
        wheelPropagation: false
      });
    }

  })();
});

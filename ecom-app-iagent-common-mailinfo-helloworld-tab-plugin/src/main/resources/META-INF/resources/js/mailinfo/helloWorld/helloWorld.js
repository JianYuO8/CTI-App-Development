requirejs(["js/api-common"], function(api) {

  var isFullscreen = false;
  
  window.toggleFullscreen = function() {
    isFullscreen = !isFullscreen;
    api.info.setFullscreen(isFullscreen);
  }

});

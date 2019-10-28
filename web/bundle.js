$(document).ready(function () {
  $('#labelNome').on('click', function () {
    $(this).css('background-color', 'green');
    $('#nome').val('teste');
    $('#salvar').hide(2050);
  });
});

$(document).ready(
    function () {
        $('#labelNome').on('click',
            function () {
                $(this).css('background-color', 'green');
                $('#nome').val('teste');
                $('#salvar').hide(2000);
            })
    }
);

class TodoList{
    constructor(){
        this.todos=[];
    }
     
    addTodo(){
        this.todos.push('novo');
        console.log(this.todos);
    }
}

class outra extends TodoList{
    constructor(){
        super();

        this.usuario = "Diego";
        
    }    

    mostraUsuario(){
      console.log(this.usuario);
    }
}

var MinhaLista = new outra();
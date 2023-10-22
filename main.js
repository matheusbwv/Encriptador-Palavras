const prompt = require('prompt-sync')();

const alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

function main() {
  let texto = prompt("Digite o texto a ser criptografado: ");
  let chave = prompt("Digite a chave: ");

  if (chave.length > texto.length) {
    alert("A chave é muito grande!");
    return;
  }

  texto = texto.toUpperCase();
  chave = chave.toUpperCase();

  let escolha = prompt("Escolha uma opção:\n1 - Criptografar\n2 - Descriptografar\n3 - Sair\n");

  while (escolha !== "1" && escolha !== "2" && escolha !== "3") {
    escolha = prompt("Escolha uma opção válida:\n1 - Criptografar\n2 - Descriptografar\n3 - Sair\n");
  }

  let textoFinal = "";

  if (escolha === "1" || escolha === "2") {
    for (let i = 0; i < texto.length; i++) {
      if (texto[i] !== " ") {
        let posicaoLetraTexto = alfabeto.indexOf(texto[i]);
        let posicaoLetraChave = alfabeto.indexOf(chave[i % chave.length]);

        if (escolha === "1") {
          textoFinal += alfabeto[(posicaoLetraTexto + posicaoLetraChave) % alfabeto.length];
        } else if (escolha === "2") {
          textoFinal += alfabeto[(posicaoLetraTexto - posicaoLetraChave + alfabeto.length) % alfabeto.length];
        }
      } else {
        textoFinal += " ";
      }
    }
  } else {
    alert("Bye bye!");
    return;
  }

  console.log("Seu resultado: " + textoFinal);
}

main();
(ns curso.aula5)

(def estoque {"Mochila" 10 "Camiseta" 5})
(println estoque)

(def estoque {"Mochila" 10, "Camiseta" 5})

(def estoque {"Mochila"  10
              "Camiseta" 5})
(println estoque)

(println "Temos" (count estoque) "elementos")
(println "Chaves são" (keys estoque))
(println "Valores são" (vals estoque))

; keyword
; :mochila
(def estoque {:mochila  10
              :camiseta 5})

(println (assoc estoque :cadeira 3))
(println estoque)
(println (assoc estoque :mochila 1))

(println estoque)
(println (update estoque :mochila inc))

(defn tira-um
  [valor]
  (println "tirando um de" valor)
  (- valor 1))

(println estoque)
(println (update estoque :mochila tira-um))
(println (update estoque :mochila #(- % 3)))

(println (dissoc estoque :mochila))



(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(println "\n\n\n\n")
(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
(println pedido)

; raro de ser usado, pois se o pedido for null vai dar nullPointerException
(println (pedido :mochila))                                 ;mapa como função
(println (get pedido :mochila))
(println (get pedido :cadeira))
(println (get pedido :cadeira 0))
(println (get pedido :cadeira {}))
(println (:mochila pedido))
(println (:cadeira pedido))
(println (:cadeira pedido 0))
(println (:cadeira pedido {}))

(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))

; THREADING FIRST  -> colecao no inicio
(println pedido)
(println (-> pedido
             :mochila
             :quantidade))

(-> pedido
    :mochila
    :quantidade
    println)

(ns curso.aula6)


(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprimi-e-15 [valor]
  (println "valor" (class valor) valor)
  15)

(println (map imprimi-e-15 pedido))

;(defn imprimi-e-15 [chave valor]
;  (println chave "e" valor)
;  15)
;
;(println (map imprimi-e-15 pedido))


(defn imprimi-e-15 [[chave valor]]
  valor)

(println (map imprimi-e-15 pedido))

(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))

;THREAD LAST   -> colecao no final
(defn total-do-pedido
  [pedido]
  (->> pedido
       (map preco-dos-produtos)
       (reduce +)))

(println (total-do-pedido pedido))



(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

;THREAD LAST   -> colecao no final
(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(println (total-do-pedido pedido))



(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [item]
  ;(println item)
  (<= (get item :preco 0) 0))

(println "Filtrando gratuito?")
(println (filter gratuito? (vals pedido)))



(defn gratuito?
  [[_ item]]
  ;(println item)
  (<= (get item :preco 0) 0))

(println "Filtrando gratuito?")
(println (filter gratuito? pedido))





(defn gratuito?
  [item]
  ;(println item)
  (<= (get item :preco 0) 0))

(println "Filtrando gratuito?")
(println (filter (fn [[chave item]] (gratuito? item)) pedido))

(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

(println ((comp not gratuito?) {:preco 50}))

(def pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

(defn imprime-mensagem []
  (println "Bem vindo(a) ao estoque!"))

(imprime-mensagem)


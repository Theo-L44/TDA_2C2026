def recibirInput(): #trabajo el input para luego resolverlo
    cantidadNodos=int(input())
    relacionesVecinos = []

    for i in range(0,cantidadNodos-1):
        relacion=input()
        relacion=relacion.split()
        relacionesVecinos.append((int(relacion[0]),int(relacion[1]))) #con esto me construyo la lista de relaciones

    verificarSecuencia=[]
    a=input()
    verificarSecuencia=a.split()
    
    for i in range(0,cantidadNodos):
        verificarSecuencia[i]=int(verificarSecuencia[i]) #convierto todas las posiciones en int

    #return(print(verificarSecuencia), print(relacionesVecinos))
    return(resolver(cantidadNodos,relacionesVecinos,verificarSecuencia))

def resolver(n,relacionesVecinos,secuencia):
    respuesta="no"

    


    return respuesta

recibirInput()
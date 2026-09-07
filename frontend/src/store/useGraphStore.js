import { create } from 'zustand';

export const useGraphStore = create((set) => ({
    nodes: [{ data: { id: '1', label: 'Notiță Inițială' }, position: { x: 150, y: 150 } }],
    edges: [],
    addNode: (id, label) => set((state) => ({
        nodes: [...state.nodes, { data: { id, label }, position: { x: Math.random() * 300, y: Math.random() * 300 } }]
    }))
}));
